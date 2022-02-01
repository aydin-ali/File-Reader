/** A music file object that extends the Media class
 * Adds on the length, artist, and album of the song
 * @author aydin-ali kachra
 * @version 1
 */

public class Music extends Media {

    //instance variables
    private int songLength; //measured in seconds
    private String artistName;
    private String albumName;

    /** Creates a new Music object
     * @param fileName - name of the music file
     * @param fileType - type of music file
     * @param fileSize - size of the music file in MB
     * @param songLength - the length of the song in seconds
     * @param artistName - the name of the artist who sings the song
     * @param albumName - the name of the album the song belongs to
     */
    public Music(String fileName, String fileType, double fileSize, int songLength, String artistName, String albumName) {
        super(fileName, fileType, fileSize);
        this.songLength = songLength;
        this.artistName = artistName;
        this.albumName = albumName;
    }

    /** Returns the length of the song
     * @return the song length
     */
    public int getSongLength() {
        return this.songLength;
    }

    /** Returns the name of the song's artist
     * @return the song's artist
     */
    public String getArtistName() {
        return this.artistName;
    }

    /** Returns the name of the song's album
     * @return the song's album
     */
    public String getAlbumName() {
        return this.albumName;
    }

    /** Returns which application launches when you open a music file
     * Completes abstract method from Media class
     * @return the application that launches when the music file opens
     */
    public  String openFile() {
        return "Launching Spotify...";
    }

    /** Finds if the Music object is equal another object
     * Overrides equals() in Media class
     * @param other - object which you are comparing the Music file to
     * @return whether the two objects are equal or not
     */
    public boolean equals(Object other) {
        //checks if the super class is equal, otherwise there's no point on checking the rest
        if (super.equals(other)) {
            if (other == null) {
                return false;
            }
            if (!(other instanceof Music)) {
                return false;
            }
            Music toCompare = (Music) other;
            if (this.songLength == toCompare.songLength &&
                    this.artistName.equals(toCompare.artistName) &&
                    this.albumName.equals(toCompare.albumName)) {
                return true;
            }
            return false;
        }
        return false;
    }

    /** Creates and returns a string rep of the Music object
     * Overrides toString() in Media class
     * @return the string rep of the Media object
     */
    public String toString() {
        return "Media Type: music, " + super.toString() + ", Song Length: " + this.songLength + "s, Artist: " + artistName + ", Album: " + albumName;
    }
}