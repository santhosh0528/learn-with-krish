var array = [ 25,24,26,22,21,23,28,30,29 ];
array.sort();
var i,j,k;

for (let i = 0; i < array.length; i++) {
    j = array[i];
    k = array[i+1];
    if(j+1 != k){
        console.log(j+1);
        break;
    }else if((j+1 == k) && (i==array.length-1)){
        console.log(k+1);
    }
  }
