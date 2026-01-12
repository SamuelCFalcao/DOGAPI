package DogService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DogService {
    private final List<String> favorites = new ArrayList<>();
    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> fetchAllBreeds() {
        String url = "https://dog.ceo/api/breeds/list/all";
        return restTemplate.getForObject(url, Map.class);
    }

    public List<String> fetchImagesOfBreed(String breed) {
        String url = String.format("https://dog.ceo/api/breed/%s/images", breed);
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        return (List<String>) response.get("message");
    }

    public ResponseEntity<String> addFavorite(String imageUrl) {
        if (favorites.contains(imageUrl)) return ResponseEntity.badRequest().body("Erro");
        favorites.add(imageUrl);
        return ResponseEntity.ok("Sucesso");
    }

    public List<String> getFavorites() {
        return favorites;
    }

    public ResponseEntity<String> removeFavorite(String imageUrl) {
        if (favorites.remove(imageUrl)) return ResponseEntity.ok("Removido");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro");
    }
}