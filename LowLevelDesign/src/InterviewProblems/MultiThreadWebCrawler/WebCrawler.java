package InterviewProblems.MultiThreadWebCrawler;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.BlockingDeque;

public class WebCrawler {

    private final BlockingDeque<String> urlQueue;
    private final Set<String> visited;

    private final ExecutorService executor;

    private final int maxThreads;

    public WebCrawler(int maxThreads){
        this.maxThreads = maxThreads;
        this.urlQueue = new LinkedBlockingDeque<>();
        this.visited = ConcurrentHashMap.newKeySet();
        this.executor =  Executors.newFixedThreadPool(maxThreads);
    }

    public void startCrawling(String seedUrl){
        urlQueue.add(seedUrl);
        visited.add(seedUrl);

        for(int i = 0; i < maxThreads; i++){
            executor.submit(new CrawlerWorker());
        }
    }

    private class CrawlerWorker implements Runnable{

        @Override
        public void run(){
            while(true){
                try{
                    String url =  urlQueue.take();
                    crawl(url);
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
        private void crawl(String url){
            System.out.println("Crawling: " + url);
            String html =  PageFetcher.fetch(url);
            List<String> links =  HtmlParser.parseLinks(html);

            for(String link: links){
                if(visited.add(link)){
                    urlQueue.add(link);
                }
            }
        }
    }

    public void shutdown(){
        executor.shutdown();
    }
}
