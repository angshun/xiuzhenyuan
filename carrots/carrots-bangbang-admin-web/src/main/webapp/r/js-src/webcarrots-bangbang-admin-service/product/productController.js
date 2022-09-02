'use strict';
angular.module('carrots_bangbang')
    .controller('productCtrl', function($state,$scope, $rootScope,$cookies,commonUtil, productService) {

        var vm = $scope.vm = {};
        
         vm.params = {    
                   	     id: $state.params.id
	                              ,  
                     	     name: $state.params.name
	                              ,  
                     	     logo: $state.params.logo
	                              ,  
                     	     summary: $state.params.summary
	                              ,  
                     	     slogan: $state.params.slogan
	                              ,  
                     	     cid: $state.params.cid
	                              ,  
                     	     createAt: $state.params.createAt
	                              ,  
                     	     updateAt: $state.params.updateAt
	                              ,  
                     	     createBy: $state.params.createBy
	                              ,  
                     	     updateBy: $state.params.updateBy
	                         };


    productService.getList(vm.params).then(function(res) {
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
        
        $state.go("field.productList", vm.params,{reload:true});
    };
    });
