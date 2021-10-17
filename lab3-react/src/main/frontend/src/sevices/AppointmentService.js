import axios from "axios";

const API_APPOINTMETNS = 'http://localhost:8080/api/v1/appointments';

class AppointmentService {

    getAll() {
        return axios.get(API_APPOINTMETNS);
    }

    save(appointment) {
        return axios.post(API_APPOINTMETNS, appointment);
    }

    delete(id) {
        return axios.delete(API_APPOINTMETNS + '/' + id);
    }

}

export default new AppointmentService()