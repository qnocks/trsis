var app = angular.module('doctors', [])

app.controller("doctorsController", ($scope, $http) => {

    $scope.doctors = [
        {
            id: 0,
            fullName: "Mark",
            specialy: "ENT",
            schedule: "14:15-16:30"
        }
    ]



    $scope.list = () => {
        $http.get('/api/v1/doctors').success((data, status, headers, config) => {
            $scope.doctors = data;
        }).error((data, status, headers, config) => {
            if (data.message === 'Time is out') {
                $scope.finishByTimeout();
            }
        })
    }

    $scope.delete = (id) => {
        $http.delete()
    }

    $scope.create = (doctor) => {
        $http.post('/api/v1/doctors').then($scope.successAddSchoolCallback, $scope.errorAddSchoolCallback);
    };

})