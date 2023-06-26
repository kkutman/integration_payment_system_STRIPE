package peaksoft.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import peaksoft.PaymentServicesSer;
import peaksoft.dto.CheckoutForm;

@Controller
@RequiredArgsConstructor
public class WebController {
    private final PaymentServicesSer paymentServices;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("checkoutForm", new CheckoutForm());
        return "index";
    }

    @PostMapping("/")
    public String checkout(@ModelAttribute("checkoutForm")CheckoutForm checkoutForm, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        model.addAttribute("amount",checkoutForm.getAmount());
        return "checkout";
    }

    @GetMapping("/payment/{paymentId}")
    public String payment(@PathVariable("paymentId") String paymentId, Model model) {
        model.addAttribute("response", paymentServices.paymentMethod(paymentId));
        return "payment";
    }

}
