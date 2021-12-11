var app = angular.module('app', []);

app.controller("doctorsController", function ($scope, $http) {

    $scope.doctors = [
        {
            id: 0,
            fullName: "Mark",
            specialty: "ENT",
            schedule: "14:15-16:30"
        },
        {
            id: 1,
            fullName: "Tom",
            specialty: "Therapist",
            schedule: "08:30-17:30"
        }
    ];

    $scope.getAll = function () {
        $http.get('/api/v1/doctors').then($scope.successGetCallback, $scope.errorGetCallback);
    };

    $scope.save = function (doctor) {
        $http.post('/api/v1/doctors', doctor).then($scope.successSaveCallback, $scope.successSaveCallback);
    };

    $scope.delete = function (id) {
        $scope.deletedId = id;
        $http.delete('api/v1/doctors/' + id).then($scope.successDeleteCallback, $scope.errorDeleteCallback);
    };

// -------- callbacks ---------
    $scope.successGetCallback = function (response) {
        $scope.doctors = response.data;
        $scope.errormessage="";
    };

    $scope.errorGetCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to get list of doctors";
    };

    $scope.successSaveCallback = function (response) {
        $http.get('/api/v1/doctors').then($scope.successGetSchoolCallback, $scope.errorGetSchoolCallback);
        $scope.errormessage="";
    };

    $scope.errorSaveCallback = function (error) {
        console.log(error);
        $scope.errormessage="Cannot add  doctor";
    };

    $scope.successDeleteCallback = function (response) {
        for (var i = 0; i < $scope.doctors.length; i++) {
            var d = $scope.doctors[i];
            if (d.id === $scope.deletedId) {
                $scope.doctors.splice(i, 1);
                break;
            }
        }
        $scope.errormessage="";
    };

    $scope.errorDeleteCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to delete doctor";
    };
})
