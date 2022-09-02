'use strict';
angular.module('carrots_bangbang')

    .factory('pathProject', function (commonUtil) {
        return {
                	     professionTag: function (id) {
                if (!id) {
                    return "ajax/u/professionTag";
                } else {
                    return "ajax/u/professionTag/" + id;
                }
            },
          professionTag_list: "ajax/u/professionTag/search"
          
                                   ,  
                        
          
         
         	     professionTag: function (id) {
                if (!id) {
                    return "ajax/u/professionTag";
                } else {
                    return "ajax/u/professionTag/" + id;
                }
            },
          professionTag_list: "ajax/u/professionTag/search"
          
                                   ,  
                        
          
         
         	     professionTag: function (id) {
                if (!id) {
                    return "ajax/u/professionTag";
                } else {
                    return "ajax/u/professionTag/" + id;
                }
            },
          professionTag_list: "ajax/u/professionTag/search"
          
                                   ,  
                        
          
         
         	     professionTag: function (id) {
                if (!id) {
                    return "ajax/u/professionTag";
                } else {
                    return "ajax/u/professionTag/" + id;
                }
            },
          professionTag_list: "ajax/u/professionTag/search"
          
                                   ,  
                        
          
         
         	     professionTag: function (id) {
                if (!id) {
                    return "ajax/u/professionTag";
                } else {
                    return "ajax/u/professionTag/" + id;
                }
            },
          professionTag_list: "ajax/u/professionTag/search"
          
                                   ,  
                        
          
         
         	     professionTag: function (id) {
                if (!id) {
                    return "ajax/u/professionTag";
                } else {
                    return "ajax/u/professionTag/" + id;
                }
            },
          professionTag_list: "ajax/u/professionTag/search"
          
                        
          
         
         
        }
    })
    
           
	    .factory('articleService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.article(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.article(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.article_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.article(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.article(id));
            }
           
        }
    })
                
	    .factory('productService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.product(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.product(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.product_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.product(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.product(id));
            }
           
        }
    })
                
	    .factory('companyService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.company(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.company(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.company_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.company(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.company(id));
            }
           
        }
    })
                
	    .factory('professionService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.profession(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.profession(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.profession_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.profession(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.profession(id));
            }
           
        }
    })
                
	    .factory('companyTagService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.companyTag(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.companyTag(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.companyTag_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.companyTag(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.companyTag(id));
            }
           
        }
    })
                
	    .factory('professionTagService', function ($http, pathProject) {
        return {
            add: function (params) {
                return $http.post(pathProject.professionTag(), params);
            },
            update: function (id, params) {
              
                return $http.put(pathProject.professionTag(id), params);
            },
            getList: function (params) {
                return $http.get(pathProject.professionTag_list, {params: params});
            },
            get: function (id) {
                return $http.get(pathProject.professionTag(id));
            },            
            del: function (id) {
                
                return $http.delete(pathProject.professionTag(id));
            }
           
        }
    })
             
   
    ;






