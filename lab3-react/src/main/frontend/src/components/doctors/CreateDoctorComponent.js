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

    save() {
        console.log('start to save')
        let doctor = {
            fullName: this.state.fullName,
            specialty: this.state.specialty,
            schedule: this.state.schedule
        };
        DoctorService.save(doctor).then(res => {
            console.log(res);
        });
    }

    render() {
        return (
            <div className="container">
                <form>
                    <div class="form-group">
                        <label for="fullName">Full name</label>
                        <input type="text" class="form-control" id="fullName" />
                    </div>
                    <div class="form-group">
                        <label for="specialty"> Specialty</label>
                        <input type="text" class="form-control" id="specialty" name="specialty" />
                    </div>
                    <div class="form-group">
                        <label for="schedule"> Schedule</label>
                        <input type="text" class="form-control" id="schedule" name="schedule" />
                    </div>
                    <input type="submit" class="btn btn-primary" onClick={this.save} value="Add" />
                </form>
            </div>
        )
    }
}

export default CreateDoctorComponent;