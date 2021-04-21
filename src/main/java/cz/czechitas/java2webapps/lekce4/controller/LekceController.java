package cz.czechitas.java2webapps.lekce4.controller;

import cz.czechitas.java2webapps.lekce4.entity.Lekce;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Kontroler obsluhující sekci lekcí.
 */
@Controller()
@RequestMapping("/lekce")
public class LekceController {
    private final List<Lekce> lekceAll;

    public LekceController(){
      lekceAll=List.of(
              new Lekce("Lekce 1", LocalDate.of(2021,4, 21), LocalTime.of(18,00), LocalTime.of(20,30), "V mechu"),
              new Lekce("Lekce 2", LocalDate.of(2021,4, 28), LocalTime.of(18,00), LocalTime.of(20,30), "V kapradí"),
              new Lekce("Lekce 3", LocalDate.of(2021,5, 5), LocalTime.of(18,00), LocalTime.of(20,30), null)
      );
    };
  /**
   * Metoda kontroleru obsluhující adresu {@code /lekce/}. Používá šablonu {@code /templates/lekce/index.html}.
   */
  @GetMapping("/")
  public ModelAndView lekce() {
    ModelAndView maw = new ModelAndView("lekce/index");
    maw.addObject("lekceAll", lekceAll);
    return maw;
  }
}
