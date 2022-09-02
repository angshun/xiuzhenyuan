'use strict';
angular.module('carrots_bangbang')
    .controller('managerCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, managerService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     mobile: $state.params.mobile
	                              ,  
                     	     rid: $state.params.rid
	                              ,  
                     	     pwd: $state.params.pwd
	                              ,  
                     	     name: $state.params.name
	                              ,  
                     	     status: $state.params.status
	                              ,  
                     	     createAt: $state.params.createAt
	                              ,  
                     	     updateAt: $state.params.updateAt
	                              ,  
                     	     createBy: $state.params.createBy
	                              ,  
                     	     updateBy: $state.params.updateBy
	                         };


    managerService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.managerList", vm.params,{reload:true});
    };
    });
