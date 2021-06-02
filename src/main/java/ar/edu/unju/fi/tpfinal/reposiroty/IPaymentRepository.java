package ar.edu.unju.fi.tpfinal.reposiroty;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.models.Payment;

public interface IPaymentRepository extends CrudRepository<Payment, String > {

}
