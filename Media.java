/** A simple general media file object that contains the file name, type, and size
 * Contains an abstract method where each type of file opens differently
 * @author aydin-ali kachra
 * @version 1
 */

public abstract class Media {

    //instance variables
    private String fileName;
    private String fileType;
    private double fileSize; //measured in megabytes

    /** Creates a new Media object
     * @param fileName - name of the photo file
     * @param fileType - type of photo file
     * @param fileSize - size of the photo file in MB
     */
    public Media(String fileName, String fileType, double fileSize) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }

    /** Returns the name of the file
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }

    /** Returns the type of the file
     * @return the file type
     */
    public String getFileType() {
        return fileType;
    }

    /** Returns the size of the file
     * @return the file size
     */
    public double getFileSize() {
        return fileSize;
    }

    /** Returns which application launches when you open a specific type of file
     * Incomplete method
     */
    public abstract String openFile();

    /** Finds if the Media object is equal another object
     * @param other - object which you are comparing the Media file to
     * @return whether the two objects are equal or not
     */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof Media)) {
            return false;
        }
        Media toCompare = (Media) other;
        if (this.fileName.equals(toCompare.fileName) &&
                this.fileType.equals(toCompare.fileType) &&
                this.fileSize == toCompare.fileSize) {
            return true;
        }
        return false;
    }

    /** Creates and returns a string rep of the Media object
     * @return the string rep of the Media object
     */
    public String toString() {
        return "File: " + fileName + "." + fileType + ", File Size: " + fileSize + " MB";
    }

}