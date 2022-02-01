/** A photo file object that extends the Media class
 * Adds on the width and height of the photo
 * @author aydin-ali kachra
 * @version 1
 */

public class Photo extends Media {

    //instance variables
    private int imageWidth; //measured in pixels
    private int imageHeight; //measured in pixels

    /** Creates a new Photo object
     * @param fileName - name of the photo file
     * @param fileType - type of photo file
     * @param fileSize - size of the photo file in MB
     * @param imageWidth - the width of the image in pixels
     * @param imageHeight - the height of the image in pixels
     */
    public Photo(String fileName, String fileType, double fileSize, int imageWidth, int imageHeight) {
        super(fileName, fileType, fileSize);
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
    }

    /** Returns the width of the image
     * @return the image width
     */
    public int getImageWidth() {
        return this.imageWidth;
    }

    /** Returns the height of the image
     * @return the image height
     */
    public int getImageHeight() {
        return this.imageHeight;
    }

    /** Calculates the resolution of the image
     * @return the image resolution
     */
    public int imageResolution() {
        return this.imageWidth * this.imageHeight;
    } //resolution = width * height of photo

    /** Returns which application launches when you open a photo file
     * Completes abstract method from Media class
     * @return the application that launches when the photo file opens
     */
    public  String openFile() {
        return "Launching Preview...";
    }

    /** Finds if the Photo object is equal another object
     * Overrides equals() in Media class
     * @param other - object which you are comparing the Photo file to
     * @return whether the two objects are equal or not
     */
    public boolean equals(Object other) {
        //checks if the super class is equal, otherwise there's no point on checking the rest
        if (super.equals(other)) {
            if (other == null) {
                return false;
            }
            if (!(other instanceof Photo)) {
                return false;
            }
            Photo toCompare = (Photo) other;
            if (this.imageWidth == toCompare.imageWidth &&
                    this.imageHeight == toCompare.imageHeight) {
                return true;
            }
            return false;
        }
        return false;
    }

    /** Creates and returns a string rep of the Photo object
     * Overrides toString() in Media class
     * @return the string rep of the Photo object
     */
    public String toString() {
        return "Media Type: photo, " + super.toString() + ", Image Width: " + this.imageWidth + "px, Image Height: " + this.imageHeight + "px";
    }
}