package com.example.Pedro.Accounting;


import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.util.Date;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

import DTO.AccountingDTO1;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
@SpringBootTest
class PedroAccountingApplicationTests {
	private ObjectMapper mapper = new ObjectMapper();
	private final String accountURL = "http://localhost:8080";
	
	public void testPostOrder() {
		
		AccountingDTO1 account = new AccountingDTO1("1","1","Sabão", new Date(),1.1, 3.4, true);
		Response resp = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(account)
				.post(accountURL);
		assertEquals(HttpStatus.CREATED.value(), resp.getStatusCode());
	}
 
		public void testCreateAccountingExists(){
		AccountingDTO1 duplicateaccount = new AccountingDTO1("2","2","Água", new Date(),2.3, 4.3, true);
		Response resp = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(duplicateaccount)
				.post(accountURL);
		
		assertEquals(HttpStatus.CREATED.value(), resp.getStatusCode());
		}
		
		public void testCreateAccountingInvalid() {
			AccountingDTO1 invalidaccounting = new AccountingDTO1("3", "-4","", new Date(),2.0,3.5, true);
			Response resp = RestAssured
					.given()
					.contentType(ContentType.JSON)
					.body(invalidaccounting)
					.post(accountURL);
			
			assertEquals(HttpStatus.CREATED.value(), resp.getStatusCode());
			}
		public void testTogglerAccountingActive() {
			long accountCode = 2;
			
			AccountingDTO1 originalAccount = RestAssured
					.given()
					.contentType(ContentType.JSON)
					.get(accountURL + "/" + accountCode)
					.as(AccountingDTO1.class);
			
			  boolean originalState = originalAccount.isActive();

			    originalAccount.setActive(!originalState);

			    Response response = RestAssured
			        .given()
			        .contentType(ContentType.JSON)
			        .body(originalAccount)
			        .put(accountURL + "/" + accountCode);
			    assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatusCode());
			    

			    AccountingDTO1 updatedAccount = RestAssured
			        .given()
			        .contentType(ContentType.JSON)
			        .get(accountURL + "/" + accountCode)
			        .as(AccountingDTO1.class);
			    assertNotEquals(originalState, updatedAccount.isActive());
			    
			}
		public void testTogglerAccountingActiveNotExistent() {
			long nonExistentAccountCode = 10000;
			
			AccountingDTO1 nonExistentAccount = new AccountingDTO1("1000", "50", "Galão", new Date(), 2.9, 7.8, true);
			
			 Response response = RestAssured
				        .given()
				        .contentType(ContentType.JSON)
				        .body(nonExistentAccount)
				        .put(accountURL + "/" + nonExistentAccountCode);

				    assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());	
		}
		}
		

	

