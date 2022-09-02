'use strict';
angular.module('carrots_bangbang')
    .controller('professionTagCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, professionTagService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     cId: $state.params.cId
	                              ,  
                     	     pId: $state.params.pId
	                              ,  
                     	     tag: $state.params.tag
	                              ,  
                     	     createAt: $state.params.createAt
	                              ,  
                     	     updateAt: $state.params.updateAt
	                              ,  
                     	     createBy: $state.params.createBy
	                              ,  
                     	     updateBy: $state.params.updateBy
	                              ,  
                              };


    professionTagService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.professionTagList", vm.params,{reload:true});
    };
    });
