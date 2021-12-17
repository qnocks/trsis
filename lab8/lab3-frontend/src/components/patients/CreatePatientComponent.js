import React from "react";
import PatientService from "../../sevices/PatientService";

class CreatePatientComponent extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            fullName: '',
            birthDate: '',
            address: ''
        }
    }

    save = (e) => {
        e.preventDefault();
        let patient = {
            fullName: this.state.fullName,
            birthDate: this.state.birthDate,
            address: this.state.address
        };
        console.log(patient);
        PatientService.save(patient).then(res => {
            this.props.history.push('/patients');
        });
    }

    handleFullName(event) {
        this.setState({ fullName: event.target.value });
    }

    handleBirthDate(event) {
        this.setState({birthDate: event.target.value});
    }

    handleAddress(event) {
        this.setState({address: event.target.value});
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
                        <label for="specialty">Birthdate</label>
                        <input value={this.state.birthDate} onChange={this.handleBirthDate.bind(this)} type="text" className="form-control" id="specialty" name="specialty" />
                    </div>
                    <div className="form-group">
                        <label for="schedule">Address</label>
                        <input value={this.state.address} onChange={this.handleAddress.bind(this)} type="text" className="form-control" id="schedule" name="schedule" />
                    </div>
                    <input type="submit" className="btn btn-primary" value="Add" />
                </form>
            </div>
        )
    }
}

export default CreatePatientComponent;