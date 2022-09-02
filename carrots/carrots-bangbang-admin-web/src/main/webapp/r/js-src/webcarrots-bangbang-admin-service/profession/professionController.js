'use strict';
angular.module('carrots_bangbang')
    .controller('professionCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, professionService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     name: $state.params.name
	                              ,  
                     	     cId: $state.params.cId
	                              ,  
                     	     releaseAt: $state.params.releaseAt
	                              ,  
                     	     salary: $state.params.salary
	                              ,  
                     	     education: $state.params.education
	                              ,  
                     	     workExperience: $state.params.workExperience
	                              ,  
                     	     status: $state.params.status
	                              ,  
                     	     responsibility: $state.params.responsibility
	                              ,  
                     	     requirement: $state.params.requirement
	                	     welfare: $state.params.welfare
	                	     createAt: $state.params.createAt
	                	     updateAt: $state.params.updateAt
	                	     createBy: $state.params.createBy
	                	     updateBy: $state.params.updateBy
	                         };


    professionService.getList(vm.params).then(function(res) {
        if (res.data.code === 0) {
            vm.list = res.data.data;
            vm.page = {
                next: res.data.next || 0,
                size: res.data.size || 0,
                page: res.data.page || 0,
                total: res.data.total || 0
            };
        } else {
            $rootScope.alert(res.data.message);
        }
    });
  

    vm.search = function() {
        
        $state.go("field.professionList", vm.params,{reload:true});
    };
    });
