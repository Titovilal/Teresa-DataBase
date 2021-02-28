package BaseDatosTeresa;

import BaseDatosTeresa.TeresaDB;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

public class DriveApi {

    private static final String APPLICATION_NAME = "Teresa Database";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart. If modifying
     * these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = TeresaDB.class.getResourceAsStream(CREDENTIALS_FILE_PATH);

        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    /**
     *
     * @return @throws GeneralSecurityException
     * @throws IOException
     */
    public static Drive connection() throws GeneralSecurityException, IOException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        return service;
    }

    //public static void main(String... args) throws IOException, GeneralSecurityException {
    // Build a new authorized API client service.
    /*
        Drive service = connection();
     */
    //SUBIR IMAGENES A GOOGLE DRIVE
    /*
        File fileMetadata = new File();
        fileMetadata.setName("photo.jpg");
        java.io.File filePath = new java.io.File("C:\\files\\descarga.jpg");
        FileContent mediaContent = new FileContent("image/jpeg", filePath);
        File file = service.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();
        System.out.println("File ID: " + file.getId());
        JOptionPane.showMessageDialog(null, file.getId());
     */
    //SUBIR ARCHIVOS DE TEXTO A GOOGLE DRIVE
    /*
        File fileMetadata = new File();
        fileMetadata.setName("database.txt");
        java.io.File filePath = new java.io.File("C:\\files\\database.txt");
        FileContent mediaContent = new FileContent("text/txt", filePath);
        File file = service.files().create(fileMetadata, mediaContent)
                .setFields("id")
                .execute();
        System.out.println("File ID: " + file.getId());
        JOptionPane.showMessageDialog(null, file.getId());
     */
    //BUSCAR Y DESCARGAR ARCHIVO = database.txt
    /*
        String pageToken = null;
        String destinationFolder = "C:\\files\\download\\";
        do {
            FileList result = service.files().list()
                    .setQ("mimeType='text/txt'")
                    .setSpaces("drive")
                    .setFields("nextPageToken, files(id, name)")
                    .setPageToken(pageToken)
                    .execute();
            for (File file : result.getFiles()) {
                System.out.printf("Found file: %s (%s)\n",
                        file.getName(), file.getId());
                if (file.getName().equals("database.txt")) {
                    OutputStream outputstream = new FileOutputStream(destinationFolder + file.getName());
                    service.files().get(file.getId())
                            .executeMediaAndDownloadTo(outputstream);
                    outputstream.flush();
                    outputstream.close();

                    System.out.println("Archivo encontrado");
                }
            }
            pageToken = result.getNextPageToken();
        } while (pageToken != null);
     */
    // }
}
