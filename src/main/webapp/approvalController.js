
var app = angular.module('pharmeasy', []);
app.controller('approvalCtrl', function($scope, $http) {
   
   
   
   
    
    $scope.save = function() {
        $scope.create = {};
        $scope.create.requester=$scope.requester;
        $scope.create.prescription=$scope.pres;
        $scope.create.approvalStatus="PENDING";
        $http.post('/pe/rest/approval/request',$scope.create).then(function (response) {
            console.log(response);
        } );
    };
    
    
    $scope.loadRequester = [];
    $scope.loadPrescriptions = [];
    $scope.approvals = [];
    
    $scope.loadRequester = function() {
        $http.get('/pe/rest/profile/loadAll').then(function(response) {
         $scope.loadRequester=response.data;
         console.log("Data is "+response);
        
        });
    };
    
    $scope.loadPrescriptions = function() {        
        $http.get('/pe/rest/pres/loadAllPrescriptions').then(function (response) {
            console.log(response.data);
            $scope.loadPrescriptions = response.data;
        } );
    };
    
    
    
    $scope.loadApprovals = function() {        
        var param = $scope.requester.id;
        $http.post('/pe/rest/approval/getAllApproved',param).then(function (response) {
            console.log(response.data);
            $scope.approvals = response.data;
        } );
    };
    
   $scope.loadRequester(); 
   $scope.loadPrescriptions();
   //$scope.loadApprovals();
    
}
);