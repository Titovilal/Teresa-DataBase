package Modelo;

import BaseDatosTeresa.DriveApi;
import com.google.api.client.http.FileContent;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Salva Castells Juan
 */
public class ModeloDrive {

    private static final int MAX = 20;

    private boolean eliminar = false, renombrar = false, existe = false;
    private String idEliminar, idRenombrar;

    public ModeloDrive() {
    }

    /**
     * Conecta con la nube
     *
     * @return Devuelve la conexion para poder realizar tareas con los archivos
     */
    public Drive conectar() {
        Drive service = null;
        try {
            service = DriveApi.connection();
        } catch (GeneralSecurityException | IOException ex) {
            Logger.getLogger(ModeloDrive.class.getName()).log(Level.SEVERE, null, ex);

        }
        return service;
    }

    /**
     * Descarga el archivo seleccionado en la carpeta indicada
     *
     * @param service
     * @param nameFile
     * @param folder
     */
    public void bajarArchivo(Drive service, String nameFile, String folder) {
        try {
            
            String pageToken;
            do {
                FileList result = service.files().list()
                        .setPageSize(MAX)
                        .setFields("nextPageToken, files(id, name)")
                        .execute();

                for (File file2 : result.getFiles()) {

                    System.out.printf("Found file: %s (%s)\n", file2.getName(), file2.getId());
                    
                    if (file2.getName().equals(nameFile)) {
                        System.out.println("Encuentra archivo");
                        try (OutputStream outputstream = new FileOutputStream(folder + nameFile)) {
                            System.out.println("Se crea nuevo file output stream");
                            service.files().get(file2.getId()).executeMediaAndDownloadTo(outputstream);
                            System.out.println("Descarga archivo");
                            outputstream.flush();
                            System.out.println("Limpia el buffer");
                            outputstream.close();
                            System.out.println("Cierra el buffer");
                        }
                    }
                }
                pageToken = result.getNextPageToken();
            } while (pageToken != null);
            System.out.println("Acaba bucle bajar archivo");
        } catch (IOException e) {
            System.out.println(e);
            JOptionPane.showConfirmDialog(null, "No se ha podido descargar el archivo.\n Revisa tu conexión a internet");
        }
    }

    /**
     * Sube un archivo a la nube. Si ya existe el nuevo es el principal y el
     * existente pasa a ser copia de seguridadS
     *
     * @param service
     * @param nameFile
     * @param destinationFolder
     */
    public void subirArchivo(Drive service, String nameFile, String destinationFolder) {
        try {

            String pageToken;
            do {
                FileList result = service.files().list()
                        .setPageSize(MAX)
                        .setFields("nextPageToken, files(id, name)")
                        .execute();

                for (File file1 : result.getFiles()) {

                    System.out.printf("Found file: %s (%s)\n", file1.getName(), file1.getId());
                    //Busca archivo con mismo nombre
                    if (file1.getName().equals(nameFile)) {
                        renombrar = true;
                        eliminar = true;
                        idRenombrar = file1.getId();
                    }
                    //Busca backup
                    if (file1.getName().equals("BACKUP" + nameFile)) {
                        idEliminar = file1.getId();
                        existe = true;
                    }
                }
                //Borra backup si lo ha encontrado
                if (eliminar == true && existe == true) {
                    eliminarArchivo(service, idEliminar);
                    eliminar = false;
                    existe = false;
                }
                //Renombra el archivo con el mismo nombre a backup
                if (renombrar == true) {
                    renombrarArchivo(service, idRenombrar, "BACKUP" + nameFile);
                    renombrar = false;
                }

                pageToken = result.getNextPageToken();
            } while (pageToken != null);

            File fileMetadata = new File();
            fileMetadata.setName(nameFile);

            java.io.File filePath = new java.io.File(destinationFolder);
            FileContent mediaContent = new FileContent("text/txt", filePath);
            File file = service.files().create(fileMetadata, mediaContent)
                    .setFields("id")
                    .execute();
            System.out.println("Arcfivo subido\n");
            System.out.println("File ID: " + file.getId());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido descargar el archivo");
        }
    }

    /**
     * Elimina un archivo de la nube a partir de su id
     *
     * @param service
     * @param fileId
     */
    public void eliminarArchivo(Drive service, String fileId) {
        try {
            service.files().delete(fileId).execute();
        } catch (IOException e) {
            System.out.println("No se ha podido eliminar el archivo,An error occurred: " + e);
        }
    }

    /**
     * Renombra el arvhivo con la ID seleccionada
     *
     * @param service
     * @param id
     * @param newName
     * @throws IOException
     */
    public void renombrarArchivo(Drive service, String id, String newName) throws IOException {
        File fileMetadata = new File();
        fileMetadata.setName(newName);
        //service.files().update(id, fileMetadata).execute();
        Drive.Files.Update update;
        update = service.files().update(id, fileMetadata);
        update.execute();
    }
}
