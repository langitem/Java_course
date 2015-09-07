// Emanuel Langit// elangit@my.smccd.edu// CIS 255WJ// MP3.java// Class MP3 with instance variables for: artist, song, album, track length// Assignment #8// May 17, 2012public class MP3 implements Comparable< MP3 > {        private String artist;        private String song;        private String album;        private int trackLength; // track length in seconds        public MP3( String artistName, String songName, String albumName, int trackLength ){                setArtist( artistName );                setSong( songName );                setAlbum( albumName );                setTrackLength( trackLength );        }        public String getArtist() {                return artist;        }        public void setArtist( String artist ) {                this.artist = artist;        }        public String getSong() {                return song;        }        public void setSong( String song ) {                this.song = song;        }        public String getAlbum() {                return album;        }        public void setAlbum( String album ) {                this.album = album;        }        public int getTrackLength() {                return trackLength;        }        public void setTrackLength( int trackLength ) {                this.trackLength = trackLength;        }        public String toString() {                int minutes = trackLength / 60;                int seconds = trackLength % 60;                return String.format( "%s, %s, %s, %d:%02d", getArtist(), getSong(), getAlbum(), minutes, seconds );        }		@Override		public int compareTo( MP3 other ) {			// TODO Auto-generated method stub			return artist.compareToIgnoreCase( other.artist );		}}