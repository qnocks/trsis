import React from "react";

const IndexComponent = () => {
    return (
        <div className="text-center">
            <a href="/doctors" className="btn btn-info">Doctors</a>
            <a href="/patients" className="btn btn-info">Patients</a>
            <a href="/appointments" className="btn btn-info">Appointments</a>
        </div>
    )
}

export default IndexComponent;