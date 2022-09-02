'use strict';
angular.module('carrots_bangbang')
    .controller('moduleCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, moduleService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     name: $state.params.name
	                              ,  
                     	     pid: $state.params.pid
	                              ,  
                     	     type: $state.params.type
	                              ,  
                     	     menuId: $state.params.menuId
	                              ,  
                     	     icon: $state.params.icon
	                              ,  
                     	     level: $state.params.level
	                              ,  
                     	     url: $state.params.url
	                              ,  
                     	     createAt: $state.params.createAt
	                              ,  
                     	     updateAt: $state.params.updateAt
	                	     createBy: $state.params.createBy
	                	     updateBy: $state.params.updateBy
	                         };


    moduleService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.moduleList", vm.params,{reload:true});
    };
    });
