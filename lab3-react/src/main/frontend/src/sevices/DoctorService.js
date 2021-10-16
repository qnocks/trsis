import axios from "axios";

const API_DOCTORS = 'http://localhost:8080/api/v1/doctors';

class DoctorService {

    getAll() {
        return axios.get(API_DOCTORS);
    }

    save(doctor) {
        return axios.post(API_DOCTORS, doctor);
    }

    deleteDoctor() {
        // TODO: DELETE
    }

}

export default new DoctorService()