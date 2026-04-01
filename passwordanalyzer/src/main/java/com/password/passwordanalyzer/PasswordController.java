package com.password.passwordanalyzer;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.password.passwordanalyzer.engine.EntropyCalculator;
import com.password.passwordanalyzer.engine.StrengthEvaluator;


@Controller
public class PasswordController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/analyze")
    public String analyze(@RequestParam String password, Model model) {

        double entropy = EntropyCalculator.calculateEntropy(password);
        String strength = StrengthEvaluator.evaluateStrength(password, entropy);

        model.addAttribute("password", password);
        model.addAttribute("entropy", String.format("%.2f", entropy));
        model.addAttribute("strength", strength);

        return "index";
    }
}
