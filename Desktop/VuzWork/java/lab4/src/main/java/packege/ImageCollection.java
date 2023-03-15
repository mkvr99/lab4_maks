package packege;

import javafx.scene.image.Image;
import java.nio.file.Paths;

public class ImageCollection implements Aggregate {
    private String filetopic;
    private Image bi;
    public ImageCollection(String filetopic) {
        this.filetopic = filetopic;
    }
    private class ImageIterator implements Iterator{

        private int current = 0;

        private Image getImage(int iterator){
            String filename = Paths.get("src/main/resources/img/"+ filetopic + iterator +".png").toUri().toString();
            return new Image(filename);
        }

        @Override
        public boolean hasNext(int i) {
                return !getImage(current+i).isError();
        }

        @Override
        public Object next() {
            if(this.hasNext(1)) {
                return getImage(++current);
            }
                current = 1;
                return getImage(1);
        }

        @Override
        public Object preview() {
            if(this.hasNext(-1)) {
                return getImage(--current);
            }
                current = 1;
                return getImage(1);
        }
    }
    @Override
    public Iterator getIterator() {
        return new ImageIterator();
    }
}
