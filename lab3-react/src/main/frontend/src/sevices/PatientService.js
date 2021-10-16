import axios from "axios";

const API_PATIENTS = 'http://localhost:8080/api/v1/patients';

class PatientService {

    getPatients() {
        return axios.get(API_PATIENTS);
    }
}

export default new PatientService()