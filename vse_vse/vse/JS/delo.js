
let all_elem={};

let main_work = function()
	{
		let make_block = function(w_,h_,l_,t_,p)
							{
								let ans = document.createElement('div');
								ans.setAttribute('class',"ramka bloq");
								ans.style.width=w_+"px";
								ans.style.height=h_+"px";
								ans.style.top=t_+"px";
								ans.style.left=l_+"px";
								ans.style.position=p;
								return ans;
							};
		let wi = window.innerWidth,he=window.innerHeight;
		let wdr = 0.8,hdr = 0.9;
		let mm = document.createElement("div");
		let b = document.body;
		b.setAttribute("class","telo");
		let elemnts = {};
		let blq=1;
		blq=all_elem["menu"] = elemnts["menu"] =make_block(wdr*wi,he*hdr,((1-wdr)*wi)/2,((1-hdr)*he)/2,"absolute"); 
		b.appendChild(blq);
		
		console.log(all_elem);
	};






