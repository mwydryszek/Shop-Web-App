package pl.excercise.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.excercise.jpa.model.CustomerOrderDTO;
import pl.excercise.jpa.model.CustomerOrderMapper;
import pl.excercise.jpa.repository.CustomerOrderRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerOrderServiceImpl implements CustomerOrderService{

    private final CustomerOrderRepository customerOrderRepository;


}
