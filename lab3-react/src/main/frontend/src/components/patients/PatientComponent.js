import React from "react";
import PatientService from "../../sevices/PatientService";

class PatientComponent extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            patients:[]
        }
    }

    componentDidMount() {
        PatientService.getAll().then((res) => {
            this.setState({patients: res.data})
        });
    }

    delete(id) {
        PatientService.delete(id).then(res => {
            this.setState({patients: this.state.patients.filter(d => d.id !== id)})
        });
    }

    render() {
        return (
            <div>
                <h1 className="text-center">Patients list</h1>
                <div className="row">
                    <a href="/patients/create" className="btn btn-primary">add</a>
                </div>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>Name</td>
                            <td>Birth Date</td>
                            <td>Address</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.patients.map(patient =>
                                <tr key = {patient.id}>
                                    <td>{patient.id}</td>
                                    <td>{patient.fullName}</td>
                                    <td>{patient.birthDate}</td>
                                    <td>{patient.address}</td>
                                    <td>
                                        <button onClick={() => this.delete(patient.id)} className="btn brn-info">Delete</button>
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

export default PatientComponent;