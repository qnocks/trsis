import axios from "axios";

const API_DOCTORS = 'http://localhost:8080/api/v1/doctors';

class DoctorService {

    getAll() {
        return axios.get(API_DOCTORS);
    }

    save(doctor) {
        return axios.post(API_DOCTORS, doctor);
    }

    delete(id) {
        return axios.delete(API_DOCTORS + '/' + id);
    }

}

export default new DoctorService()