package services;

import java.util.Date;
import java.time.*;

import entities.Contract;
import entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService() {};

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		
		for(int i = 1 ; i <= months ; i++) {
			
				Date date = contract.getDate(); 
				LocalDate nextInterest = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusMonths(i);
				
				Double amount = onlinePaymentService.interest(contract.getTotalValue(), i);
				amount = onlinePaymentService.paymentFee(amount);
				contract.addInstallment(new Installment(nextInterest, amount / months));

		}
	}
}
