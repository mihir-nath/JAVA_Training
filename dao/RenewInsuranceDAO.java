package dao;

import java.util.List;

public interface RenewInsuranceDAO {
        public Insurance selectInsurance(int policyNumber);
        public List<Insurance> selectExpiredInsurances();
        public void updateInsurance(Insurance ins);
}
