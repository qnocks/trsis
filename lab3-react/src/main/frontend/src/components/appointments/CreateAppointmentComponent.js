import React from "react";
import AppointmentService from "../../sevices/AppointmentService";

class CreateAppointmentComponent extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            doctorId: '',
            patientId: '',
            date: '',
            time: ''
        }
    }

    save = (e) => {
        e.preventDefault();
        let appointment = {
            doctorId: this.state.doctorId,
            patientId: this.state.patientId,
            date: this.state.date,
            time: this.state.time,
        };
        console.log(appointment);
        AppointmentService.save(appointment).then(res => {
            this.props.history.push('/appointments');
        });
    }

    handleDoctorId(event) {
        this.setState({ doctorId: event.target.value });
    }

    handlePatientId(event) {
        this.setState({patientId: event.target.value});
    }

    handleDate(event) {
        this.setState({date: event.target.value});
    }

    handleTime(event) {
        this.setState({time: event.target.value});
    }

    render() {
        return (
            <div className="container">
                <form onSubmit={this.save.bind(this)}>
                    <div className="form-group">
                        <label for="fullName">Doctor ID</label>
                        <input value={this.state.doctorId} onChange={this.handleDoctorId.bind(this)} type="text" className="form-control" id="fullName" />
                    </div>
                    <div className="form-group">
                        <label for="specialty">Patient ID</label>
                        <input value={this.state.patientId} onChange={this.handlePatientId.bind(this)} type="text" className="form-control" id="specialty" name="specialty" />
                    </div>
                    <div className="form-group">
                        <label for="schedule">Date</label>
                        <input value={this.state.date} onChange={this.handleDate.bind(this)} type="text" className="form-control" id="schedule" name="schedule" />
                    </div>
                    <div className="form-group">
                        <label for="schedule">Time</label>
                        <input value={this.state.time} onChange={this.handleTime.bind(this)} type="text" className="form-control" id="schedule" name="schedule" />
                    </div>
                    <input type="submit" className="btn btn-primary" value="Add" />
                </form>
            </div>
        )
    }
}

export default CreateAppointmentComponent;