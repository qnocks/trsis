import React from "react";
import DoctorService from "../../sevices/DoctorService";

class CreateDoctorComponent extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            fullName: '',
            specialty: '',
            schedule: ''
        }
    }

    save = (e) => {
        e.preventDefault();
        let doctor = {
            fullName: this.state.fullName,
            specialty: this.state.specialty,
            schedule: this.state.schedule
        };
        console.log(doctor);
        DoctorService.save(doctor).then(res => {
            this.props.history.push('/doctors');
        });
    }

    handleFullName(event) {
        this.setState({ fullName: event.target.value });
    }

    handleSpecialty(event) {
        this.setState({specialty: event.target.value});
    }

    handleSchedule(event) {
        this.setState({schedule: event.target.value});
    }

    render() {
        return (
            <div className="container">
                <form onSubmit={this.save.bind(this)}>
                    <div className="form-group">
                        <label for="fullName">Full name</label>
                        <input value={this.state.fullName} onChange={this.handleFullName.bind(this)} type="text" className="form-control" id="fullName" />
                    </div>
                    <div className="form-group">
                        <label for="specialty"> Specialty</label>
                        <input value={this.state.specialty} onChange={this.handleSpecialty.bind(this)} type="text" className="form-control" id="specialty" name="specialty" />
                    </div>
                    <div className="form-group">
                        <label for="schedule"> Schedule</label>
                        <input value={this.state.schedule} onChange={this.handleSchedule.bind(this)} type="text" className="form-control" id="schedule" name="schedule" />
                    </div>
                    <input type="submit" className="btn btn-primary" value="Add" />
                </form>
            </div>
        )
    }
}

export default CreateDoctorComponent;