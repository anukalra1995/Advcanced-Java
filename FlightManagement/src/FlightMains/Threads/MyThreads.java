package FlightMains.Threads;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;

public class MyThreads extends Thread {
	
	@Override
	public void run() {
		
		try(WatchService service = FileSystems.getDefault().newWatchService()){
			
			Map<WatchKey,Path> keyMap = new HashMap<>();
			
			Path path = Paths.get("AdvFiles");
		
			//A Map that can be used to configure the watchService
			keyMap.put(path.register(service,
									StandardWatchEventKinds.ENTRY_CREATE,
									StandardWatchEventKinds.ENTRY_DELETE,
									StandardWatchEventKinds.ENTRY_MODIFY),
						path);
			
			WatchKey watchKey;
			do {
				watchKey = service.take();
				Path eventDir = keyMap.get(watchKey);
				
				for(WatchEvent<?> event : watchKey.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();
					Path eventPath = (Path) event.context();
					System.out.println(eventDir + ": "+ kind + ": " + eventPath);
					
				}
				
				
			} while (watchKey.reset());
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
