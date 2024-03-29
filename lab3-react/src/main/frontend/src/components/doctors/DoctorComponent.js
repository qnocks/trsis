import React from "react";
import DoctorService from "../../sevices/DoctorService";

class DoctorComponent extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            doctors:[]
        }
    }

    componentDidMount() {
        DoctorService.getAll().then(res => {
            this.setState({doctors: res.data})
        });
    }

    delete(id) {
        DoctorService.delete(id).then(res => {
            this.setState({doctors: this.state.doctors.filter(d => d.id !== id)})
        });
    }

    render() {
        return (
            <div>
                <h1 className="text-center">Doctors list</h1>
                <div className="row">
                    <a href="/doctors/create" className="btn btn-primary">add</a>
                </div>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>Name</td>
                            <td>Specialty</td>
                            <td>Schedule</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.doctors.map(doctor =>
                                <tr key = {doctor.id}>
                                    <td>{doctor.id}</td>
                                    <td>{doctor.fullName}</td>
                                    <td>{doctor.specialty}</td>
                                    <td>{doctor.schedule}</td>
                                    <td>
                                        <button onClick={() => this.delete(doctor.id)} className="btn btn-info">Delete</button>
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

export default DoctorComponent;