package in.stackroute.umove.userservice.service.implementation;

import in.stackroute.umove.userservice.model.UserData;
import in.stackroute.umove.userservice.model.UserPaymentMethod;
import in.stackroute.umove.userservice.repository.UserRepository;
import in.stackroute.umove.userservice.service.PaymentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements PaymentServiceInterface {

    @Autowired
    UserRepository userRepository;
    /*
    API FOR GETTING ALL THE PAYMENT OF PARTICULAR USER
     */
    @Override
    public List<UserPaymentMethod> getPayments(String objid) {
        UserData userData = userRepository.getUserByid(objid);
        List<UserPaymentMethod> savedUserPayment = userData.getPaymentMethod();
        return savedUserPayment;
    }
    /*
    API FOR ADDING PAYMENT METHOD
     */
    @Override
    public List<UserPaymentMethod> addNewPaymentMethod(String objid, UserPaymentMethod userPaymentMethod) {
        UserData userData = userRepository.getUserByid(objid);
        List<UserPaymentMethod> savedUserPayment = userData.getPaymentMethod();
        savedUserPayment.add(userPaymentMethod);
        userData.setPaymentMethod(savedUserPayment);
        return userRepository.save(userData).getPaymentMethod();
    }

    /*
    API FOR GETTING PAYMENT BY ID
     */

    public UserPaymentMethod getPaymentMethodById(String objid, int pid) {
        List<UserPaymentMethod> userPaymentMethodList = userRepository.getUserByid(objid).getPaymentMethod();
        for (UserPaymentMethod method : userPaymentMethodList) {
            if (method.getPId() == pid) {
                System.out.println(method);
                return method;
            }
        }
        return null;
    }

    /*
    API FOR UPDATE PAYMENT METHOD
     */
    public UserPaymentMethod updatePaymentMethodById(String objid, int pid, UserPaymentMethod userPaymentMethod) {
        UserData userData = userRepository.getUserByid(objid);
        List<UserPaymentMethod> userPaymentMethodList = userData.getPaymentMethod();
        UserPaymentMethod m = null;
        for (UserPaymentMethod method : userPaymentMethodList) {
            if (method.getPId() == pid) {
                if (method != null) {
                    if (userPaymentMethod.getPaymentMethodNumber() != null) {
                        method.setPaymentMethodNumber(userPaymentMethod.getPaymentMethodNumber());
                    }
                    if (userPaymentMethod.getPaymentProvider() != null) {
                        method.setPaymentProvider(userPaymentMethod.getPaymentProvider());
                    }
                    if (userPaymentMethod.getPaymentType() != null) {
                        method.setPaymentProvider(userPaymentMethod.getPaymentProvider());
                    }
                }
                m = method;
            }
            userRepository.save(userData);
        }
        return m;
    }
    /*

    API for DELETE THE PAYMENT METHOD
     */
    public void deletePaymentMethodById(String objid, int pid ) {
        UserData userData = userRepository.getUserByid(objid);
        List<UserPaymentMethod> userPaymentMethodList = userData.getPaymentMethod();
        for (UserPaymentMethod method : userPaymentMethodList) {
            if (method.getPId() == pid) {
                System.out.println(method);
                userPaymentMethodList.remove(method);
            }
            userRepository.save(userData);
        }
    }
}
