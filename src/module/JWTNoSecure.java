package module;

import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class JWTNoSecure {
	
	public String encode(String header, String payload) {
		Encoder encoder = Base64.getEncoder();
		String headerBase64 = encoder.encodeToString(header.getBytes());
		String payloadBase64 = encoder.encodeToString(payload.getBytes());
		return headerBase64 + "." + payloadBase64;
	}
	
	public String decode(String jwtNoSecure) {
		Decoder decoder = Base64.getDecoder();
		String[] jwtNoSecureSplit = jwtNoSecure.split("\\.");
		String payloadEncode = jwtNoSecureSplit[1];
		return new String(decoder.decode(payloadEncode));
	}
	
	public static void main(String[] args) {
		JWTNoSecure jwtNoSecure = new JWTNoSecure();
		String header = "{alg : none}";
		String payload = "test";
		String encode = jwtNoSecure.encode(header, payload);
		System.out.println(encode);
		String decode = jwtNoSecure.decode(encode);
		System.out.println(decode);
	}
}
