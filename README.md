
#### blue-rabbit


##### To start project:
 -- run 'mvn package -Dmaven.test.skip && java -jar target/blue-rabbit.jar' to run
 - 'curl localhost:8080/health' to check the server status
 ## Interface
 
 - open browser,input url => **http://{Host}:8080/api/ip/{ip}/isp** will get isp info
 - open browser,input url => **http://{Host}:8080/api/ip/{ip}/city** will get location info
 - open browser,input url => **http://{Host}:8080/api/ua?userAgent={user-agent}** will analyze user-agent info
  
 
       
