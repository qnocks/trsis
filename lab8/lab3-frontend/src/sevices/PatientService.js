import axios from "axios";

const API_PATIENTS = 'http://localhost:8080/api/v1/patients';

class PatientService {

    getAll() {
        return axios.get(API_PATIENTS);
    }

    save(patient) {
        return axios.post(API_PATIENTS, patient);
    }

    delete(id) {
        return axios.delete(API_PATIENTS + '/' + id);
    }
}

export default new PatientService()