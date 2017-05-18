
var app = angular.module('pharmeasy', []);
app.controller('patientCtrl', function($scope, $http) {
   
    
    $scope.save = function() {
        console.log($scope.pres);
        $http.post('/pe/rest/pres/save',$scope.pres).then(function (response) {
            console.log(response);
            
        } );
    };
    
    
    $scope.approve = function(request) {
        console.log(request);
        $http.post('/pe/rest/approval/approve',request).then(function (response) {
            console.log(response);
        } );
    };
    
    
    $scope.loadPatient = [];
    $scope.pendingRequests = [];
    
    $scope.loadPatient = function() {
        $http.get('/pe/rest/profile/loadPatients').then(function(response) {
         $scope.loadPatient=response.data;
         console.log("Data is "+response);
        
        });
    };
    
    $scope.loadPendingRequests = function() {        
        var param = $scope.patient.id;
        $http.post('/pe/rest/approval/getAllPending',param).then(function (response) {
            console.log(response.data);
            $scope.pendingRequests = response.data;
        } );
    };
    
    $scope.loadPatient();
}
);