package WatchService;
import java.nio.file.*;
import java.io.IOException;

public class DirectoryWatcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get("/path/to/watch");
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, 
                                    StandardWatchEventKinds.ENTRY_DELETE, 
                                    StandardWatchEventKinds.ENTRY_MODIFY);

        System.out.println("Monitoring directory: " + path);
        
        while (true) {
            WatchKey key = watchService.take();
            key.pollEvents().forEach(event -> {
                WatchEvent.Kind<?> kind = event.kind();
                System.out.println(kind.name() + ": " + event.context());
            });
            if (!key.reset()) break;
        }
    }
}
