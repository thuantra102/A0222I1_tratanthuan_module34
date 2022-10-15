

import java.io.IOException;

public class HttpDownloader {

	public static void main(String[] args) {
		String fileURL = "https://dl140v.y2mate.com/?file=M3R4SUNiN3JsOHJ6WWQ2a3NQS1Y5ZGlxVlZIOCtyZ1gzZlpzZ2pGekwrQjQ0NjU4a3IzNURlNEVBNU0vaHNHUk91Y2YwUnY3VVBTdWUwU3E4N3R3QjFMUStaMFEvQnladHF4d1dJSkpWMTNjM3NQeTB4Tlh6Q2FpY0piQUJlc1FhMzUzcG45ejBqS2JrYlNHbnd6M3BtbTRwVWpHUGdJSG9taE9iOU9KdE0xdXhDU2FTZUxSZ01jZnV3ZlI3NG9hblBlWXUxekE3ZlE3b014OFRFRmdlcDFZaE11amlhV2Y4aGRJMU1oYXlVUytyTC8xVjhaaFMvREdQeVJtWXlZTHNBPT0%3D";
		String saveDir = "D:\\CODEGYM\\module4\\ss5_orm\\exercise\\untitled\\src\\Download";
		try {
			HttpDownloadUtility.downloadFile(fileURL,saveDir);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}