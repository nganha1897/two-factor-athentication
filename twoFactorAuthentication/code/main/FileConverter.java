import java.util.Map;

/**
 * File: FileConverter.java
 * Interface FileConverter for BasicFileConverter.java
 *
 * @author Ha Tran
 * @author Kalsang Sherpa
 *
 * @date 12/09/2018
 * CPSC 385
 */

public interface FileConverter {
    public void serializeUser (Map<String, User> manager);
    
    public void serializePad (Map<String, String> padManager);
    
    public Map<String, User> deserializeUser();
    
    public Map<String, String> deserializePad();

    public boolean doesFileExist();

    public void fileClose();
}

