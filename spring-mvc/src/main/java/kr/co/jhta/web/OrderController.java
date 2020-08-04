package kr.co.jhta.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.form.OrderForm;
import kr.co.jhta.service.OrderService;
import kr.co.jhta.service.ProductService;
import kr.co.jhta.vo.Product;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/step1.do")
	public String step1(@RequestParam("no") long productNo, Model model) {
		Product product = productService.getProductDetail(productNo);
		
		OrderForm orderForm = new OrderForm();
		orderForm.setProductNo(product.getNo());
		orderForm.setProductName(product.getName());
		orderForm.setProductPrice(product.getPrice());
		orderForm.setProductDiscountPrice(product.getDiscountPrice());

		model.addAttribute("orderForm", orderForm);
		
		System.out.println("step1 단계 화면 표시 전 OrderForm: " + orderForm);

		return "order/step1";
	}
	
	@PostMapping("/step2.do")
	public String step2() {
		return "redirect:step3.do";
	}
	
	@PostMapping("/step3.do")
	public String step3() {
		return "redirect:step4.do";
	}
	
	@PostMapping("/step4.do")
	public String step4() {
		return "redirect:completed.do";
	}
}
