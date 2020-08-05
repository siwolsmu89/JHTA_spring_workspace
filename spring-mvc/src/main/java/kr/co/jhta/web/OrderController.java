package kr.co.jhta.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.jhta.form.OrderForm;
import kr.co.jhta.service.OrderService;
import kr.co.jhta.service.ProductService;
import kr.co.jhta.vo.Delivery;
import kr.co.jhta.vo.Item;
import kr.co.jhta.vo.Order;
import kr.co.jhta.vo.Payment;
import kr.co.jhta.vo.Product;

@Controller
@RequestMapping("/order")
@SessionAttributes("orderForm")
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	
	@GetMapping("/step1.do")
	public String step1(@RequestParam("no") long productNo, Model model) {
		// 구매버튼을 클릭한 상품정보를 조회한다.
		Product product = productService.getProductDetail(productNo);
		
		// 구매상품정보, 구매자정보, 결재정보, 배송지정보를 저장하는 OrderForm객체 생성한다.
		OrderForm orderForm = new OrderForm();
		
		// OrderForm객체에 구매상품정보를 저장한다.
		orderForm.setProductNo(product.getNo());
		orderForm.setProductName(product.getName());
		orderForm.setProductPrice(product.getPrice());
		orderForm.setProductDiscountPrice(product.getDiscountPrice());
		// OrderForm객체를 Model에 저장한다.
		// @SessionAttributes("orderForm") 어노테이션 설정 때문에 OrderForm은 세션에 저장된다.
		// OrderForm객체는 브라우저를 종료하거나, 로그아웃하기 전까지는 계속 유지된다.
		model.addAttribute("orderForm", orderForm);
		
		System.out.println("step1단계 화면 표시전 OrderForm : " + orderForm);
		
		// 구매자정보 입력화면으로 이동한다.
		return "order/step1";
	}
	
	@PostMapping("/step1.do")
	public String step1Submit(@ModelAttribute("orderForm") OrderForm orderForm) {
		System.out.println("step1단계 완료 후 OrderForm : " + orderForm);
		
		return "redirect:step2.do";
	}
	
	@GetMapping("/step2.do")
	public String step2() {
		return "order/step2";
	}
	
	@PostMapping("/step2.do")
	public String step2Submit(@ModelAttribute("orderForm") OrderForm orderForm) {
		System.out.println("step2단계 완료 후 OrderForm : " + orderForm);
		
		return "redirect:step3.do";
	}
	
	@GetMapping("/step3.do")
	public String step3() {
		return "order/step3";
	}
	
	@PostMapping("/step3.do")
	public String step3Submit(@ModelAttribute("orderForm") OrderForm orderForm) {
		System.out.println("step3단계 완료 후 OrderForm : " + orderForm);
		
		return "redirect:step4.do";
	}
	
	@GetMapping("/step4.do")
	public String step4() {
		return "order/step4";
	}
	
	@PostMapping("/step4.do")
	public String step4Submit(@ModelAttribute("orderForm") OrderForm orderForm) {
		System.out.println("step4단계 완료 후 OrderForm : " + orderForm);

		Order order = new Order();
		order.setUsername(orderForm.getUsername());
		order.setTel(orderForm.getUsertel());
		
		Item item = new Item();
		item.setProductNo(orderForm.getProductNo());
		item.setPrice(orderForm.getPrice());
		item.setAmount(orderForm.getAmount());

		Payment payment = new Payment();
		payment.setType(orderForm.getPayType());
		payment.setAccount(orderForm.getPayAccount());
		
		Delivery delivery = new Delivery();
		delivery.setUsername(orderForm.getReceiverUsername());
		delivery.setTel(orderForm.getReceiverTel());
		delivery.setAddress(orderForm.getReceiverAddress());
		
		orderService.order(order, item, payment, delivery);
		
		return "redirect:completed.do";
	}
	
	@GetMapping("/completed.do")
	public String completed(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "order/completed";
	}
	
	@GetMapping("/cancel.do")
	public String cancel(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/product/list.do";
	}
	
}