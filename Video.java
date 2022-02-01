/** A video file object that extends the Media class
 * Adds on the length and resolution of the video
 * @author aydin-ali kachra
 * @version 1
 */

public class Video extends Media {

    //instance variables
    private int videoLength; //measured in seconds
    private String videoResolution;

    /** Creates a new Video object
     * @param fileName - name of the video file
     * @param fileType - type of video file
     * @param fileSize - size of the video file in MB
     * @param videoLength - the length of the video in seconds
     * @param videoResolution - the resolution of the video
     */
    public Video(String fileName, String fileType, double fileSize, int videoLength, String videoResolution) {
        super(fileName, fileType, fileSize);
        this.videoLength = videoLength;
        this.videoResolution = videoResolution;
    }

    /** Returns the length of the video
     * @return the video length
     */
    public int getVideoLength() {
        return this.videoLength;
    }

    /** Returns the resolution of the video
     * @return the video resolution
     */
    public String getVideoResolution() {
        return this.videoResolution;
    }

    /** Returns which application launches when you open a video file
     * Completes abstract method from Media class
     * @return the application that launches when the video file opens
     */
    public  String openFile() {
        return "Launching QuickTime Player...";
    }

    /** Finds if the Video object is equal another object
     * Overrides equals() in Media class
     * @param other - object which you are comparing the Video file to
     * @return whether the two objects are equal or not
     */
    public boolean equals(Object other) {
        //checks if the super class is equal, otherwise there's no point on checking the rest
        if (super.equals(other)) {
            if (other == null) {
                return false;
            }
            if (!(other instanceof Video)) {
                return false;
            }
            Video toCompare = (Video) other;
            if (this.videoLength == toCompare.videoLength &&
                    this.videoResolution.equals(toCompare.videoResolution)) {
                return true;
            }
            return false;
        }
        return false;
    }

    /** Creates and returns a string rep of the Video object
     * Overrides toString() in Media class
     * @return the string rep of the Video object
     */
    public String toString() {
        return "Media Type: video, " + super.toString() + ", Video Length: " + this.videoLength + "s, Video Resolution: " + videoResolution;
    }
    }