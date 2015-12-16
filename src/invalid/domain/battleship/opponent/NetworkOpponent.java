package invalid.domain.battleship.opponent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import invalid.domain.battleship.Battleship;
import invalid.domain.battleship.pieces.Peg;
import invalid.domain.battleship.models.AbstractOpponent;

public class NetworkOpponent implements AbstractOpponent {
	boolean isServer;
	boolean open;
	
	ServerSocket server;
	Socket sock;
	BufferedReader in;
	PrintWriter out;
	Gson gson;
	
	public NetworkOpponent(boolean isServer, String addr) {
		open = true;
		gson = new GsonBuilder()
	             .disableHtmlEscaping()
	             .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
	             .setPrettyPrinting()
	             .serializeNulls()
	             .create();
		
		if (isServer) {
			try {
				server = new ServerSocket(Integer.parseInt(addr));
				sock = server.accept();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("\ttl;dr you dun fukt up son");
			}
		} else {
			try {
				sock = new Socket(addr.split(":")[0], 
						Integer.parseInt(addr.split(":")[1]));
			} catch(IOException e) {
				e.printStackTrace();
				System.out.println("\ttl;dr you dun fukt up son");
			}
		}
		
		try {
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("\ttl;dr you dun fukt up son");
		}
	}
	
	public Peg getMove() {
		JsonParser parser = new JsonParser();
		String jsonString = null;
		
		try {
			jsonString = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (parser.parse(jsonString).getAsJsonObject().get("id").equals("targetPeg"))
			return gson.fromJson(jsonString, Peg.class);
		else {
			System.out.println("getMove called, received other. throwing exception for trace");
			new Exception().printStackTrace();
			return null;
		}
	}
	
	public Boolean getResult() {
		JsonParser parser = new JsonParser();
		JsonObject temp = null;
		String jsonString = null;
		
		try {
			jsonString = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp = parser.parse(jsonString).getAsJsonObject();
		
		if (temp.get("id").equals("targetResult"))
			return temp.get("didHit").getAsBoolean();
		else {
			System.out.println("getResult called, received other. throwing exception for trace");
			new Exception().printStackTrace();
			return null;
		}
		
	}
	
	public void sendMove(Peg p) {
		out.print(gson.toJson(p));
	}
	
	public void sendResult(boolean didHit) {
		JsonObject obj = new JsonObject();
		obj.addProperty("id", "targetResult");
		obj.addProperty("didHit", didHit);
		out.print(gson.toJson(obj));
		
	}
	
	public void close() {
		try {
			in.close();
			out.close();
			sock.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		open = false;
	}
}