import React from "react";
import AppointmentService from "../../sevices/AppointmentService";

class AppointmentComponent extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            appointments:[]
        }
    }

    componentDidMount() {
        AppointmentService.getAll().then(res => {
            this.setState({appointments: res.data})
        });
    }

    delete(id) {
        AppointmentService.delete(id).then(res => {
            this.setState({appointments: this.state.appointments.filter(d => d.id !== id)})
        });
    }

    render() {
        return (
            <div>
                <h1 className="text-center">Appointments list</h1>
                <div className="row">
                    <a href="/appointments/create" className="btn btn-primary">add</a>
                </div>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>Doctor ID</td>
                            <td>Patient ID</td>
                            <td>date</td>
                            <td>time</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.appointments.map(appointment =>
                                <tr key = {appointment.id}>
                                    <td>{appointment.id}</td>
                                    <td>{appointment.doctorId}</td>
                                    <td>{appointment.patientId}</td>
                                    <td>{appointment.date}</td>
                                    <td>{appointment.time}</td>
                                    <td>
                                        <button onClick={() => this.delete(appointment.id)} className="btn btn-info">Delete</button>
                                    </td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default AppointmentComponent;